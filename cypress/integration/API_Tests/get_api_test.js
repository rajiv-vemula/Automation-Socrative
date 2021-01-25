describe('GET API for REST',()=>{

    it('API for MotorBike',()=>{
        cy.request('https://flask-rest-api-demo.herokuapp.com/product/motorbike').then((res) =>{
        expect(res.status).equal(200)
        expect(res.body.product[0]).has.property('price',599.99)
        expect(res.body.product[0]).has.property('product','motorbike')
        })
    })


    it('API for Users',()=>{
        cy.request('https://flask-rest-api-demo.herokuapp.com/users').then((res) =>{
        expect(res.status).equal(200)
        expect(res.body.users[0]).has.property('username','test_1')
        expect(res.body.users[1]).has.property('id',2)
        expect(res.body.users).has.length(5)
        expect(res.body.users[0]).not.have.property('price')
        })
    })

    it('API for Regres',()=>{
        cy.request('https://regres.in/api/users?page=2').then((res) =>{
        expect(res.status).equal(200)
        // expect(res.body.data[0]).has.property('first_name','Michael')
        // expect(res.body.data[1]).has.property('email','lindsay.ferguson@regres.in')
        expect(res.body.data).has.length(6)
        })
    })
})