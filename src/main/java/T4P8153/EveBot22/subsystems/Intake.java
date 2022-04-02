package T4P8153.EveBot22.subsystems;

import static T4P8153.EveBot22.Constants.*;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Intake extends SubsystemBase {
    private WPI_VictorSPX intakeMotor;

    public Intake() 
    {
        intakeMotor = new WPI_VictorSPX(victor_Intake);
    }

    public void periodic() {}

    public void spin(boolean reverse) {
        if (!reverse) {
            intakeMotor.set(ControlMode.PercentOutput, intakeSpeed);
        } else if (reverse) {
            intakeMotor.set(ControlMode.PercentOutput, -intakeSpeed);
        }
    }

    public void stop() {
        intakeMotor.stopMotor();
    }
}
