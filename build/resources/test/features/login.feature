Feature: Login funcional

  Scenario Outline: Validar login con distintos usuarios

    Given el usuario abre el navegador y va a la pagina de login
    When ingresa usuario "<usuario>" y contrasena "<password>"
    Then el sistema muestra el mensaje "<mensaje>"

    Examples:
      | usuario     | password | mensaje             |
      | 15507186-9  | admin    | Welcome             |
      | 15507186-9  | 1234     | Wrong password      |
      | usuarioX    | admin    | User does not exist|