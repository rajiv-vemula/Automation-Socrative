class LoginPage
{
    visit()
    {
        cy.visit('https://b.socrative.com/login/teacher/')
    }

    fillEmail(value)
    {
        const field = cy.get('[type=email]')
        field.clear().type(value)
        return this
    }

    fillPassword(value)
    {
        const field = cy.get('[type=password]')
        field.clear().type(value)
        return this
    }

    submit()
    {
        const button = cy.get('[type=submit]')
        button.click()
    }

}

export default LoginPage