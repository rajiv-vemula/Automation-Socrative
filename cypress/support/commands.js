// ***********************************************
// This example commands.js shows you how to
// create various custom commands and overwrite
// existing commands.
//
// For more comprehensive examples of custom
// commands please read more here:
// https://on.cypress.io/custom-commands
// ***********************************************
//
//
// -- This is a parent command --
// Cypress.Commands.add("login", (email, password) => { ... })
//
//
// -- This is a child command --
// Cypress.Commands.add("drag", { prevSubject: 'element'}, (subject, options) => { ... })
//
//
// -- This is a dual command --
// Cypress.Commands.add("dismiss", { prevSubject: 'optional'}, (subject, options) => { ... })
//
//
// -- This will overwrite an existing command --
// Cypress.Commands.overwrite("visit", (originalFn, url, options) => { ... })

import 'cypress-file-upload';
import '@testing-library/cypress/add-commands';

Cypress.Commands.add('login',(email,password) => {
    cy.get('.login').click()
    cy.get('#email').type(email)
    cy.get('#passwd').type(password)
    cy.get('#SubmitLogin').click()
})

Cypress.Commands.add('search',(product)=>{
    cy.get('#search_query_top').type(product) 
    cy.get("button[name='submit_search']").click()
})

Cypress.Commands.add('SocrativeLogin',(Email, Password)=>{
    cy.get('input[name="email"]').type(Email)               // email
    cy.get('input[name="password"]').type(Password)      // password
    // Click on Sign In Button
    cy.get('#teacherLoginButton').click()

    
    

})
