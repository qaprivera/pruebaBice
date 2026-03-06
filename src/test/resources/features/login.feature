Feature: Login funcional

  Scenario Outline: Validar mensaje de error usuario no registrado

    Given el usuario esta en la pagina de login
    When ingresa email "nsnsn@gmail.com" y contrasena "password"
    Then hace click en login y aparece el mensaje "Este usuario no está registrado en la nueva Sucursal Virtual de Metrogas, para registrarlo, debes dirigirte a: Soy nuevo y no tengo usuario."

