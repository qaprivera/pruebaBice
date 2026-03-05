Feature: Login funcional

  Scenario Outline: Validar mensaje de error

    Given el usuario esta en la pagina de login
    When ingresa email "nsnsn@gmail.com" y contrasena "password"
    Then hace click en login

