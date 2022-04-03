package T4P8153.EveBot22.commands;

import java.util.function.DoubleSupplier;

import T4P8153.EveBot22.subsystems.Arm;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class armSpin extends CommandBase {
    private final Arm arm;

    private DoubleSupplier throttleSupplier;

    public armSpin(Arm subsys, DoubleSupplier throttle) {
        arm = subsys;

        addRequirements(this.arm);

        throttleSupplier = throttle;
    }

    @Override
    public void execute() {
        double speed = throttleSupplier.getAsDouble();

        arm.spin(speed);
    }

    @Override
    public void end(boolean interrupted) {
        arm.stop();
    }


    
}
