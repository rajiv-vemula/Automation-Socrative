
Given('The Teacher visits the Socrative url for Login',()=>{
    cy.visit('https://b.socrative.com/login/teacher/')
});

When('The Teacher enters',(datatable)=>{
    datatable.hashes().forEach(element => {
        ccy.get('#email').type(element.email)
        cy.get('#passwd').type(element.password)
    });
})

When('The Teacher clicks on Sign In Option',()=>{
    cy.get('#SubmitLogin').click()
});

Then('The Teacher views the Socrative Home Page',()=>{
    cy.url().should('include','/#launch')
})