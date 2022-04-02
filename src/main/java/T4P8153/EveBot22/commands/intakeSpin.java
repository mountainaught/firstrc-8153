package T4P8153.EveBot22.commands;

import T4P8153.EveBot22.subsystems.Intake;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class intakeSpin extends CommandBase{
    private final Intake intake;

    private boolean reverse;

    public intakeSpin(Intake subsys, boolean reverse) {
        intake = subsys;

        addRequirements(this.intake);

        this.reverse = reverse;
    }

    @Override
    public void execute() {
        intake.spin(reverse);
    }

    @Override
    public void end(boolean interrupted) {
        intake.stop();
    }

}
