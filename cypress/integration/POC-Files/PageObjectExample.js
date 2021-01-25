import LoginPage from '../PageObjects/LoginPage'

describe('Socrative POM',()=>{

    it('POM Example for Login',()=>{

        const login = new LoginPage()
        login.visit()
        login.fillEmail('rajiv@showbie.com')
        login.fillPassword('92cktaYV@')
        login.submit()

        cy.url().should('contain','#launch')
        cy.title().should('be.equal','Socrative')
    })
})