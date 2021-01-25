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

    it('Launch a Quiz',function(){
       
        cy.visit(this.data.SocrativeTeacherURL)
        cy.SocrativeLogin(this.data.email , this.data.password)
    
        // validating the url
        cy.url().should('include','/#launch')

        // Click on Launch Button
        cy.get('.launch-button-row-1 > div:nth-child(1)')
        .click()

        // Select the quiz
        cy.contains(this.data.QuizName).click()

        // Click Next Button
        cy.contains('Next').click()

        //Instant Feedback
        cy.contains('Instant Feedback').click()

        //Start Quiz
        cy.get('.start-quiz-footer-button.start-quiz-start-button').click()
        cy.wait(1000)

    })



    after('Sign Out from the Application',()=>{

        // Click on Finish 
        cy.contains('Finish').click()
        cy.get('.mr-2').click() 

        cy.wait(1000)

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
         
    })
    
})