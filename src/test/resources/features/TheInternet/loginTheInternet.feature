# language: es

Característica: Autenticación en la plataforma The Internet

  Antecedentes:
    Dado que el usuario navega a la página de login de The Internet

  @Smoke @Regression @Positive @qase:1
  Escenario: Inicio de sesión exitoso con credenciales válidas
    Cuando ingresa el usuario "tomsmith" y la contraseña "SuperSecretPassword!"
    Y hace clic en el botón de login
    Entonces debe ver el mensaje de éxito "You logged into a secure area!"
    Y la URL debe ser "https://the-internet.herokuapp.com/secure"

  @Negative
  Esquema del escenario: Inicio de sesión fallido con credenciales incorrectas
    Cuando ingresa el usuario "<usuario>" y la contraseña "<password>"
    Y hace clic en el botón de login
    Entonces debe ver el mensaje de error "<mensaje_error>"

    @qase:2
    Ejemplos: Username incorrecto
      | usuario  | password             | mensaje_error             |
      | usertest | SuperSecretPassword! | Your username is invalid! |

    @qase=3
    Ejemplos: Password incorrecta
      | usuario  | password             | mensaje_error             |
      | tomsmith | wrongpassword        | Your password is invalid! |
