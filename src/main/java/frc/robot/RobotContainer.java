// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;
//LIBRERIAS, IMPORTACIONES: (COMANDOS, SUBSISTEMAS, OBJETOS, ETC)//
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import frc.robot.Commands.EjCommand;
import frc.robot.Subsystems.Subsystem;
//---------------------------------------------------------------//
public class RobotContainer {

  //ESPACIO PARA DECLARAR OBJETOS//

  //Tipo "especial" de control de XBOX (CommandXboxController)
  //Los botones de este tipo de control, vienen con triggers para usar directamente con COMANDOS 
  private final CommandXboxController micontrol = new CommandXboxController(0); //Crea un control de XBOX en el puerto USB 0

  //CREA UNA NUEVA INSTANCIA DE SUBSISTEMA EN EL ROBOT CONTAINER
  private final Subsystem miSubsistema = new Subsystem();

  //-----------------------------//

  public RobotContainer() {

    configureBindings();
  }

  private void configureBindings() {
    /////////////////AQUÍ SE ACTIVARÁN LOS COMANDOS MEDIANTE EL USO DE LOS TRIGGERS/////////////////////

    //USO DE LOS BOTONES PARA TRIGGEAR COMANDOS, 
    //CREA UNA NUEVA INSTANCIA DEL COMANDO
    //PARAMETROS : LE PASAREMOS EL SUBSISTEMA CREADO ARRIBA Y LA VELOCIDAD A LA QUE QUEREMOS QUE SE MUEVA EL MOTOR
    micontrol.a().whileTrue(new EjCommand(miSubsistema, 0.5));

    //EJ2:
    micontrol.b().whileTrue(new EjCommand(miSubsistema, -0.4));
    //GRACIAS A CÓMO ESTRUCTURAMOS EL COMANDO, PODEMOS CREAR VARIAS INSTANCIAS DEL COMANDO CON DIFERENTES VELOCIDADES

    //EJ3:
    micontrol.y().whileTrue(new EjCommand(miSubsistema, 1));

    //------------------------------------------------------------------------------------------------//
  }

  //Función donde se va a obtener el comando creado del autónomo//
  public Command getAutonomousCommand() {
    //REGRESA EL COMANDO DE LA RUTINA DE AUTÓNOMO//
    return Commands.print("No autonomous command configured");
    //-------------------------------------------//
  }
}
