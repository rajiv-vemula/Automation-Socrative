describe('File Upload Use cases',()=>{

    it.skip('Simple File Upload',()=>{

        cy.visit('http://automationpractice.com/index.php?controller=contact')

        const yourFixturePath = 'Example_Image.png';
        cy.get('#fileUpload').attachFile(yourFixturePath);
    })

    it.skip('Drag & Drop File Upload',()=>{
        cy.visit('https://css-tricks.com/examples/DragAndDropFileUploading/')

        const yourFixturePath = 'Example_Image.png';
        cy.get('#file').attachFile(yourFixturePath);

        cy.get('.box__success').should('contain.text','Done!')
    })

    it.skip('Multiple Files Upload',()=>{

        cy.visit('https://davidwalsh.name/demo/multiple-file-upload.php')

        const yourFixturePath = 'Example_Image.png';
        const yourFixturePath1 = 'example.json';
        const yourFixturePath2 = 'profile.json';

        cy.get('#filesToUpload')
        .attachFile(yourFixturePath)
        .attachFile(yourFixturePath1)
        .attachFile(yourFixturePath2);

        cy.get('p:nth-child(6) > strong').should('contain.text','Files You Selected:')

    })

    it.skip('Change File Name while Uploading',()=>{
        cy.visit('https://davidwalsh.name/demo/multiple-file-upload.php')

        const yourFixturePath = 'Example_Image.png';

        cy.get('#filesToUpload').attachFile({filePath: yourFixturePath, fileName: 'users.json' })
    })
})