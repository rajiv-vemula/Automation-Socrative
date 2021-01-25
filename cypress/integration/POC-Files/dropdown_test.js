describe('Drop Down Feature', ()=>{

    it.skip('with select tag test',()=>{

        cy.visit('https://www.orangehrm.com/orangehrm-30-day-trial/')

        cy.get('#Form_submitForm_Country')
        .select('India')
        .should('have.value','India')

        cy.get('#Form_submitForm_Industry')
        .select('Automotive')
        .should('have.value','Automotive')       

    })

    it.skip('Google Search Test',()=>{

        cy.visit('https://www.google.com') 
        cy.get("[name='q']").type('cypress')
        
        // cy.get('.erkvQe')
        // .find('li span')
        // .contains('cypress snowshoeing')

        cy.get('.erkvQe li span').contains('cypress snowshoeing').click()

    })

    it('Automation e-commerce Search Test',()=>{

        cy.visit('http://automationpractice.com/index.php')
        cy.get('#search_query_top').type('dress')

        cy.get('.ac_results')
        .find('li')
        .contains('T-shirts').click()
    })
})