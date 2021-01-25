describe('Checkbox Functionality',()=>{

    it('Category page on automation practice - checkbox test',()=>{

        cy.visit('http://automationpractice.com/index.php?')
        cy.get('.sf-with-ul').first().click()

        // check the checkboxes & verifies its parent
        cy.get('.checkbox').check().parent().should('have.class','checked')

        // uncheck the checkboxes & verify them
        cy.get('.checkbox').uncheck().parent().should('not.have.class','checked')
    })

    it('snapdeal test - filter checkbox',()=>{

        cy.visit('https://www.snapdeal.com/')

        cy.get('#inputValEnter').type('Laptop')
        
        cy.contains('Search').click()

        // DOM is getting changed so cannot validate here 
        cy.get('[data-displayname="Brand"] > .filter-content > .filter-inner > :nth-child(n) > input')
        .check({force: true})

        cy.get('[data-displayname="Brand"] > .filter-content > .filter-inner > :nth-child(n) > input')
        .should('have.checked','checked')

        cy.get('[data-displayname="Brand"] > .filter-content > .filter-inner > :nth-child(n) > input')
        .uncheck({force: true})

        cy.get('[data-displayname="Brand"] > .filter-content > .filter-inner > :nth-child(n) > input')
        .should('not.have.checked','checked')
    })
})