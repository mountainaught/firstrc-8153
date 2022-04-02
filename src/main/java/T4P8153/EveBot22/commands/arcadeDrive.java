package T4P8153.EveBot22.commands;
import java.util.function.DoubleSupplier;

import T4P8153.EveBot22.subsystems.Drivetrain;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class arcadeDrive extends CommandBase{
    @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
    
    private final Drivetrain driveTrain;
    
    private final DoubleSupplier throttleSupplier, rotationSupplier;

    public arcadeDrive(Drivetrain subsys, DoubleSupplier throttle, DoubleSupplier rotation) {
        driveTrain = subsys;

        addRequirements(this.driveTrain);

        throttleSupplier = throttle;
        rotationSupplier = rotation;
    }

    @Override
    public void execute() {
        double throttle = throttleSupplier.getAsDouble(), rotation = rotationSupplier.getAsDouble();

        driveTrain.arcadeDrive(throttle, rotation);
    }

    @Override
    public boolean isFinished() {
        return false;
    }

}
