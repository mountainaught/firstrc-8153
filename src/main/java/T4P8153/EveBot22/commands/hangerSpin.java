package T4P8153.EveBot22.commands;

import T4P8153.EveBot22.subsystems.Hanger;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class hangerSpin extends CommandBase {
    private final Hanger hanger;

    private boolean reverse;

    public hangerSpin(Hanger subsys, boolean reverse) {
        hanger = subsys;

        addRequirements(this.hanger);

        this.reverse = reverse;
    }

    @Override
    public void execute() {
        hanger.spin(reverse);
    }

    @Override
    public void end(boolean interrupted) {
        hanger.stop();
    }
    
}
