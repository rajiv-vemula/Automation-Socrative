describe('Automation Login with method',()=>{

    before(()=>{
        cy.visit('http://automationpractice.com/index.php?')
        cy.login('rajivautomation@gmail.com','92cktaYV@')
    })

    it('should login',()=>{
        cy.url().should('include','controller=my-account')
        cy.get('.myaccount-link-list a').should('have.length',5)
    });

    it('Should Navigate to HomePage',()=>{
        cy.get('.icon-chevron-left').last().click()
        .url().should('include','index.php')
    })

    it('Search a Product',()=>{
        cy.search('Dress')
        cy.get('.lighter').should('contain.text','Dress')

    })
})