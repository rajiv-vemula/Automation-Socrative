describe('Automation Login with method',()=>{

    before(function(){

        cy.fixture('SocrativeData')
      .then(function (data) {
        // "this" is still the test context object
        this.data = data
      })
        cy.visit('http://automationpractice.com/index.php?')
        cy.login('rajivautomation@gmail.com','92cktaYV@')
    })

    it('should login',function (){
        cy.url().should('include','controller=my-account')
        cy.get('.myaccount-link-list a').should('have.length',5)
    });

    it('Should Navigate to HomePage',function(){
        cy.get('.icon-chevron-left').last().click()
        .url().should('include','index.php')
    })

    it('Search a Product',function() {
        cy.search('Dress')
        cy.get('.lighter').should('contain.text','Dress')

    })
})