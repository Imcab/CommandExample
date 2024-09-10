package frc.robot.Commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Subsystems.Subsystem;

public class EjCommand extends Command{
    //ESPACIO PARA DECLARAR OBJETOS, VARIABLES, ETC//

    Subsystem misubsistema; //declara el subsistema a utilizar
    double vel; //declara una variable de velocidad

    //---------------------------------------------//

    /**
     * <p>EN ESTA FUNCIÓN, SE VAN A DAR LOS VALORES A LOS OBJETOS DECLARADOS EN LA PARTE DE ARRIBA,
     * <p>Como en los comandos no buscamos crear otra "Instancia" del subsistema o darle un valor definido a la velocidad,
     * <p>lo que haremos será pedirlos como parámetros de la función para que, en el ROBOT CONTAINER se puedan usar
     * <p> EJEMPLO DE LOS PARÁMETROS:
     * @param Subsystem subsistema a utilizar
     * @param vel velocidad delcarada arriba
     */
    public EjCommand(Subsystem misubsistema, double vel){
        this.misubsistema = misubsistema;
        this.vel = vel; 

        addRequirements(misubsistema); //Evita conflictos entre comandos
        //Método de protección para comandos que usen el mismo subsistema
    }
    @Override
    public void initialize(){
        //Pedazo de Código que se correrá al iniciar el comando//
        System.out.println("Iniciando Comando");
        //----------------------------------------------------//
    }

    @Override
    public void execute(){
        //En nuestro caso, lo que hará cuando llamemos el comando desde el ROBOT CONTAINER,
        // va a mover el motor a una velocidad ingresada DESDE EL ROBOT CONTAINER

        //FUNCIÓN del Comando donde va a ir la acción principal//
        
        misubsistema.moverMotor(vel); 
        
        System.out.println("MOVIENDO EL MOTOR A: " + vel + " DE VELOCIDAD");
        //----------------------------------------------------//
    }

    
    @Override
    public void end(boolean interrupted) {   
        //PEDAZO DE CÓDIGO A CORRER cuando detecte que se acabe el comando con la función "isFinished()" o con un trigger(BOTON) en el ROBOT CONTAINER//
        System.out.println("El comando ha terminado");
        //--------------------------------------------------------------------------------------------------------------------------------------------//
    }

    @Override
    public boolean isFinished(){
        return false;
    }

} 
