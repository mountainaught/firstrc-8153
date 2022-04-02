package T4P8153.EveBot22.commands;
import java.util.function.DoubleSupplier;

import T4P8153.EveBot22.subsystems.Drivetrain;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class arcadeDrive extends CommandBase{
    @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
    
    private final Drivetrain driveTrain;
    
    private final DoubleSupplier driveSupplier, reverseSupplier, rotationSupplier;

    public arcadeDrive(Drivetrain subsys, DoubleSupplier driveThorttle, DoubleSupplier reverseThrottle, DoubleSupplier rotation) {
        driveTrain = subsys;

        addRequirements(this.driveTrain);

        driveSupplier = driveThorttle;
        reverseSupplier = reverseThrottle;
        rotationSupplier = rotation;
    }

    @Override
    public void execute() {

        double throttle = ( ( (driveSupplier.getAsDouble() + 1) / 2) 
        - ( (reverseSupplier.getAsDouble() + 1) /2 ) );

        // double throttle = throttleSupplier.getAsDouble(), 
        
        double rotation = rotationSupplier.getAsDouble();

        driveTrain.arcadeDrive(throttle, rotation);
    }

    @Override
    public boolean isFinished() {
        return false;
    }

}
