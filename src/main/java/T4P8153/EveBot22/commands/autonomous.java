package T4P8153.EveBot22.commands;

import T4P8153.EveBot22.subsystems.Drivetrain;
import T4P8153.EveBot22.subsystems.Intake;

import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj.Timer;

public class autonomous extends CommandBase {
    private final Drivetrain driveTrain = new Drivetrain();
    private final Intake intake = new Intake();

    private final Timer fieldTimer = new Timer();

    @Override
    public void initialize() {
        fieldTimer.reset();
        fieldTimer.start();
    }

    @Override
    public void execute() {
        while(fieldTimer.get() < 5.0) {
            if (fieldTimer.get() < 3.0) {
                // intake
                intake.spin(true);
            } else {
                intake.stop();
            }

            if (fieldTimer.get() > 3.0 && fieldTimer.get() < 5.0 ) {
                driveTrain.arcadeDrive(0.8, 0.0);
            } else {
                driveTrain.stop();
            }

        }  
    }    

    /*
    @Override
    public void end(boolean interrupted) {
        intake.stop();
        driveTrain.stop();
    }
    */

    @Override
    public boolean isFinished() {
        return true;
    }
    
}
