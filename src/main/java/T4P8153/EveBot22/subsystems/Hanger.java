package T4P8153.EveBot22.subsystems;

import static T4P8153.EveBot22.Constants.*;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Hanger extends SubsystemBase {
    private WPI_VictorSPX hangerMotor;
    
    public Hanger() 
    {
        hangerMotor = new WPI_VictorSPX(victor_Hanger);

        hangerMotor.setNeutralMode(NeutralMode.Brake);
    }

    public void periodic() {}

    public void spin(boolean reverse) {
        if (!reverse) {
            hangerMotor.set(ControlMode.PercentOutput, hangerSpeed);
        } else if (reverse) {
            hangerMotor.set(ControlMode.PercentOutput, -hangerSpeed);
        }
    }

    public void stop() {
        hangerMotor.stopMotor();
    }
    
}