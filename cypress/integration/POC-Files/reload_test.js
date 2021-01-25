describe('Reload Page', ()=>{

    it('back - fwd test',()=>{

        cy.visit('https://www.freshworks.com')
        cy.contains('Platform').click()

        cy.reload()

        cy.contains('Platform').should('be.visible')

        // Force Reload
        cy.reload(true).contains('Platform').should('be.visible')

        //Timed Reload - Seconds
        cy.reload(true,{timeout:5000})
    })
})