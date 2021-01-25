describe('Socrative Build Verification Testing', function() {

    beforeEach(()=>{
        // "this" points at the test context object
      cy.fixture('SocrativeData')
      .then(function (data) {
        // "this" is still the test context object
        this.data = data
      })
    })
  
    // it('Visit the URL & enter the credentials', function () {
    //     cy.visit(this.data.SocrativeTeacherURL)
    //     cy.SocrativeLogin(this.data.email , this.data.password)
    
    //     // validating the url
    //     cy.url().should('include','/#launch')
    // })

    it('Create a New Quiz', function () {
        cy.visit(this.data.SocrativeTeacherURL)
        cy.SocrativeLogin(this.data.email , this.data.password)
    
        // validating the url
        cy.url().should('include','/#launch')
    
        // Selecting the Quizzes Tab
        cy.get('#header-nav ul li:nth-child(2)').click()
        .should('have.class','selected')
        .url().should('include','/#quizzes')
        

        // Clicking on Add Quiz
        cy.get('.pill').
        should('have.text','ADD QUIZ').click()

        // Selecting Create New/Import Quiz
        cy.contains('Create New').click()

        cy.get('.pl-6').first()
        .should('have.text','Untitled Quiz')
        .clear()
        .type(this.data.QuizName)

        var toggle = '.rounded-round'

        // Testing the Toggle Buttons
        cy.get(toggle).eq(0).click().click()
        cy.get(toggle).eq(1).click()
        .should('not.have.class','.sharing-socnumber')
        .click()


        const socnumber = cy.get('.sharing-socnumber').invoke('text')
        socnumber.should('contain','SOC-')


        const QuestionType = 'svg.overflow-visible'
        const SaveQuestion = "button[aria-label='Save Question']"
        const DeleteQuestion = "button[aria-label='Delete Question']"
        const title = cy.get('.leading-12').invoke('text')

        title.should('equal',this.data.QuizTitle)

        //Checking the Save & Delete Question for all the 3 question types
        for(let i=0;i<3;i++)
        {
        cy.get(QuestionType).eq(i).click()
        cy.get(SaveQuestion).click().should('be.visible',QuestionType)

        cy.get(QuestionType).eq(i).click()
        cy.get(DeleteQuestion).click()
        }

        cy.wait(1000)

        // ********     Multiple Choice Question ***********
        cy.get(QuestionType).eq(0).click()

        // Question
        cy.get('.ml-2').eq(0).click().get('.ql-editor p').eq(0).type(this.data.MCQuestion1)
          
        //Options
        cy.get('.ql-editor p').eq(1).type(this.data.MCAnswer1)
        cy.get('.ql-editor p').eq(2).type(this.data.MCAnswer2)
        cy.get('.ql-editor p').eq(3).type(this.data.MCAnswer3)

        const CorrectAnswer = cy.get("svg.checkbox-icon")
        CorrectAnswer.eq(2).click()

        cy.get(SaveQuestion).click()


        //TODO -- Validate +Add Question --> Mouse Trigger

        // ********     True/False Question ***********
        // ********     MC Question         ***********
        cy.contains('True / False').should('be.visible')
        cy.contains('Multiple Choice').should('be.visible')
        cy.contains('Short Answer').should('be.visible')

        //Click on Save & Exit
        cy.contains('Save and Exit').click()

          // Validating the Quiz Name 
        cy.contains(this.data.QuizName)
        cy.get('#header-nav ul li:nth-child(1)').click()
        .should('have.class','selected')
        .url().should('include','/#launch')
   
    })


    after('Sign Out from the Application',()=>{

        // Profile Header
         cy.get('#header-user-name').click({force: true}) 

         // Sign out button
         cy.contains('SIGN OUT')
         cy.contains('SIGN OUT').click()
     
         // Assertions for the Popup
         cy.get('div.modal-header span.popup-title')
         .should('be.visible')
         .and('contain','Please Confirm')
         .and('have.length',1)
 
         // Press Yes to Continue
         cy.wait(300)
         cy.get('.button-primary.button-large').click()

         //cy.findByText
         
    })
    
})