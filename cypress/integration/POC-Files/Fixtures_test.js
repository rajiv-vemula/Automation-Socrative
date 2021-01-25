describe('User page', () => {
    beforeEach(function () {
      // "this" points at the test context object
      cy.fixture('example')
        .then((user) => {
          // "this" is still the test context object
          this.user = user
        })
    })
  
    
    it('User Login', function () {
      for(let i =0 ;i <200;i++){
        cy.visit('https://my-dev.socrative.com/login/student/')
      }
      
        // cy.get('#Email').clear().type(this.user.email)
        // cy.get('#Password').clear().type(this.user.password)
        // cy.get('input[type=submit]').click()
    })
  })


        
  