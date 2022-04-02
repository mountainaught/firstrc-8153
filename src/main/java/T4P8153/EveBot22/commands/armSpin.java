package T4P8153.EveBot22.commands;

import T4P8153.EveBot22.subsystems.Arm;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class armSpin extends CommandBase {
    private final Arm arm;

    private boolean reverse;

    public armSpin(Arm subsys, boolean reverse) {
        arm = subsys;

        addRequirements(this.arm);

        this.reverse = reverse;
    }

    @Override
    public void execute() {
        arm.spin(reverse);
    }

    @Override
    public void end(boolean interrupted) {
        arm.stop();
    }


    
}
