# language: es
@Regression
Característica: Autenticación en la plataforma The Internet

  Antecedentes:
    Dado que el usuario navega a la página de login de The Internet

  @Smoke @Positive
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

    Ejemplos:
      | usuario   | password             | mensaje_error           |
      | usuario_bad| SuperSecretPassword!| Your username is invalid!|
      | tomsmith  | PasswordIncorrecta   | Your password is invalid!|