package T4P8153.EveBot22.subsystems;
import static T4P8153.EveBot22.Constants.*;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Drivetrain extends SubsystemBase{
    private WPI_VictorSPX rFVictor, rRVictor, lFVictor, lRVictor;

    private DifferentialDrive driveTrain;

    public Drivetrain() {
        // F is Front, R is Rear
        // i hope

        
        rFVictor = new WPI_VictorSPX(victor_rF);
        rRVictor = new WPI_VictorSPX(victor_rR);

        lFVictor = new WPI_VictorSPX(victor_lF);
        lRVictor = new WPI_VictorSPX(victor_lR);

        /*
        rFVictor.setInverted(InvertType.InvertMotorOutput);
        // rRVictor.setInverted(InvertType.InvertMotorOutput);

        lRVictor.follow(lFVictor);
        rRVictor.follow(rFVictor);

        rRVictor.setInverted(InvertType.FollowMaster);;
        */

        MotorControllerGroup leftDrive = new MotorControllerGroup(lFVictor, lRVictor);
        MotorControllerGroup rightDrive = new MotorControllerGroup(rFVictor, rRVictor);

        rightDrive.setInverted(true);

        driveTrain = new DifferentialDrive(leftDrive, rightDrive);

        driveTrain.stopMotor();

    }

    public void stop() {
        driveTrain.stopMotor();
    }

    public void arcadeDrive(double throttle, double rotation) 
    {
        driveTrain.arcadeDrive(throttle, rotation);
    }

    public void arcadeDrive(double throttle, double rotation, boolean squareInput) 
    {
        driveTrain.arcadeDrive(throttle, rotation, squareInput);
    }


}
