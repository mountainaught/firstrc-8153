package T4P8153.EveBot22.subsystems;

import static T4P8153.EveBot22.Constants.*;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Arm extends SubsystemBase {
    private WPI_VictorSPX armMotor;
    
    public Arm() 
    {
        armMotor = new WPI_VictorSPX(victor_Arm);

        armMotor.setNeutralMode(NeutralMode.Brake);
    }

    public void periodic() {}

    public void spin(boolean reverse) {
        if (!reverse) {
            armMotor.set(ControlMode.PercentOutput, armSpeed);
        } else if (reverse) {
            armMotor.set(ControlMode.PercentOutput, -armSpeed);
        }
    }

    public void stop() {
        armMotor.stopMotor();
    }
    
}