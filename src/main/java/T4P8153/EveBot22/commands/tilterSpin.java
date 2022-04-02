package T4P8153.EveBot22.commands;

import T4P8153.EveBot22.subsystems.Tilter;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class tilterSpin extends CommandBase {
    private final Tilter tilter;

    private boolean reverse;

    public tilterSpin(Tilter subsys, boolean reverse) {
        tilter = subsys;

        addRequirements(this.tilter);

        this.reverse = reverse;
    }

    @Override
    public void execute() {
        tilter.spin(reverse);
    }

    @Override
    public void end(boolean interrupted) {
        tilter.stop();
    }


    
}
