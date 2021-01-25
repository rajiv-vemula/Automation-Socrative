describe('Mouse Hover Feature',()=>{

    it.skip('Click on Sign Up Link Test',()=>{

        cy.visit('https://www.spicejet.com/')
        cy.contains('Login / Signup').trigger('mouseover')
        cy.contains('SpiceClub Members').trigger('mouseover')
        cy.contains('Sign up').click()

    })

    it.skip('Click on Member Login Test',()=>{

        cy.visit('https://www.spicejet.com/')
        cy.contains('Login / Signup').trigger('mouseover')
        cy.contains('SpiceClub Members').trigger('mouseover')
        cy.contains('Member Login').click()

    })


    it('Add to Cart Test by Invoke',()=>{

        cy.visit('http://automationpractice.com/index.php')
        cy.get('.ajax_add_to_cart_button').first().click()

        cy.get('.cross').click()
        cy.wait(3000)

        cy.get('.cart_block').should('be.hidden').invoke('show')
        cy.get('#button_order_cart').click()


        cy.url().should('include','controller=order')
    })

})