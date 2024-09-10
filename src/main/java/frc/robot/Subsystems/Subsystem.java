// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.
package frc.robot.Subsystems;

//LIBRERIAS, IMPORTACIONES//
import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
//-----------------------//
public class Subsystem extends SubsystemBase {
    //ESPACIO PARA DECLARAR OBJETOS, VARIABLES//
    private final CANSparkMax motor; 
    private final RelativeEncoder encoder;
    //---------------------------------------//
  public Subsystem() {

    //Asignar valor a los objetos declarados//
    motor =  new CANSparkMax(1, MotorType.kBrushless);

    encoder = motor.getEncoder();
    //-------------------------------------//
  }

  @Override
  public void periodic() {
    //Función del susbsistema que se va actualizar constantemente// 
    //Usos: (Imprimir valores, debug, mostrar datos, etc)
    System.out.println("Rotaciones del motor: " + encoder.getPosition());
    //-----------------------------------------------------------//
    
  }

  //Método creado para interactuar con el motor desde el COMANDO//
  public void moverMotor(double velocity){
    motor.set(velocity);
  }

}
