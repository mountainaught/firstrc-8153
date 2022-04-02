package T4P8153.EveBot22.subsystems;

import static T4P8153.EveBot22.Constants.*;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Tilter extends SubsystemBase {
    private WPI_VictorSPX tilterMotor;
    
    public Tilter() 
    {
        tilterMotor = new WPI_VictorSPX(victor_Tilter);

        tilterMotor.setNeutralMode(NeutralMode.Brake);
    }

    public void periodic() {}

    public void spin(boolean reverse) {
        if (!reverse) {
            tilterMotor.set(ControlMode.PercentOutput, tilterSpeed);
        } else if (reverse) {
            tilterMotor.set(ControlMode.PercentOutput, -tilterSpeed);
        }
    }

    public void stop() {
        tilterMotor.stopMotor();
    }
    
}