describe('testing diff view ports',()=>{

    beforeEach(()=>{
        // "this" points at the test context object
      cy.fixture('SocrativeData')
      .then(function (data) {
        // "this" is still the test context object
        this.data = data
      })
    })
  
    it('Visit the Socrative Website in macbook-13 ViewPort', function () {
        cy.viewport('macbook-13')
        cy.screenshot()
        cy.wait(200)
        cy.visit(this.data.SocrativeTeacherURL)
        cy.SocrativeLogin(this.data.email , this.data.password)
    
        // validating the url
        cy.url().should('include','/#launch')
    })

  
    it('open in macbook -15', function (){
        cy.viewport('macbook-15')
        cy.screenshot()
        cy.wait(200)
        cy.visit(this.data.SocrativeTeacherURL)
        cy.SocrativeLogin(this.data.email , this.data.password)
    
        // validating the url
        cy.url().should('include','/#launch')
    })

    it('open in iphone X', function (){
        cy.viewport('iphone-x')
        cy.screenshot()
        cy.wait(200)
        cy.visit(this.data.SocrativeTeacherURL)
        cy.SocrativeLogin(this.data.email , this.data.password)
    
        // validating the url
        cy.url().should('include','/#launch')
    })

    it('open in desired view', function (){
        cy.viewport(550,750)
        cy.screenshot()
        cy.wait(200)
        cy.visit(this.data.SocrativeTeacherURL)
        cy.SocrativeLogin(this.data.email , this.data.password)
    
        // validating the url
        cy.url().should('include','/#launch')
    })


})

