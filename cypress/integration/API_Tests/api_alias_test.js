describe('API testing with Alias',()=>{

    beforeEach(()=>{
        cy.request('/user?page=2').as('users')
    })

    it('Validate the header Info',()=>{

        cy.get('@users')
         .its('headers')
          .its('content-type')
           .should('include','text/html; charset=UTF-8')
    })

    it('Validate the status',()=>{

        cy.get('@users')
         .its('status')
          .should('equal',200)
    })

    it('Validate total pages in the body',()=>{

        cy.get('@users')
         .its('body')
          .should('contains',{'total_pages': 2})
    })
})