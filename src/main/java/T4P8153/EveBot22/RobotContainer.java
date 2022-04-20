// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package T4P8153.EveBot22;

import T4P8153.EveBot22.commands.arcadeDrive;
import T4P8153.EveBot22.commands.armSpin;
import T4P8153.EveBot22.subsystems.*;
import T4P8153.EveBot22.commands.autonomous;
import T4P8153.EveBot22.commands.hangerSpin;
import T4P8153.EveBot22.commands.intakeSpin;
import T4P8153.EveBot22.commands.tilterSpin;
import static T4P8153.EveBot22.Functions.Deadband;
import static T4P8153.EveBot22.Constants.*;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and JoystickButton mappings) should be declared here.
 */
public class RobotContainer {
  Joystick js = new Joystick(0);

  private final Drivetrain driveTrain;
  private final Arm arm;
  private final Intake intake;
  private final Hanger hanger;
  private final Tilter tilter;
  

  /*
  JoystickButton D_JoystickButton = new JoystickButton(js, 1);
  JoystickButton X_JoystickButton = new JoystickButton(js, 2);
  JoystickButton O_JoystickButton = new JoystickButton(js, 3);
  JoystickButton T_JoystickButton = new JoystickButton(js, 4);
  JoystickButton L1_JoystickButton = new JoystickButton(js, 5);
  JoystickButton R1_JoystickButton = new JoystickButton(js, 6);
  JoystickButton L2_JoystickButton = new JoystickButton(js, 7);
  JoystickButton R2_JoystickButton = new JoystickButton(js, 8);
  JoystickButton Share_JoystickButton = new JoystickButton(js, 9);
  JoystickButton Option_JoystickButton = new JoystickButton(js, 10);
  JoystickButton L3_JoystickButton = new JoystickButton(js, 11);
  JoystickButton R3_JoystickButton = new JoystickButton(js, 12);
  JoystickButton PS_JoystickButton = new JoystickButton(js, 13);
  JoystickButton TouchPad = new JoystickButton(js, 14);
  */

  // The robot's subsystems and commands are defined here...

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    driveTrain = new Drivetrain();
    tilter = new Tilter();
    hanger = new Hanger();
    arm = new Arm();
    intake = new Intake();

    driveTrain.setDefaultCommand(new arcadeDrive(driveTrain, () -> js.getRawAxis(3), () -> js.getRawAxis(4),
      () -> Deadband(js.getRawAxis(0))  / driveSpeed ) );

    // Arm analog
    arm.setDefaultCommand(new armSpin(arm, () -> js.getRawAxis(5)));

    // Configure the JoystickButton bindings
    configureJoystickButtonBindings();
  }

  /**
   * Use this method to define your JoystickButton->command mappings. JoystickButtons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.JoystickButton.JoystickButton}.
   */
  private void configureJoystickButtonBindings() {

    
    // Hanger - Circle/Square
    new JoystickButton(js, 4)
      .whenHeld(new hangerSpin(hanger, false));
    new JoystickButton(js, 2)
      .whenHeld(new hangerSpin(hanger, true));

    // Intake - R1/R2
    new JoystickButton(js, 6)
      .whenHeld(new intakeSpin(intake, false));
    new JoystickButton(js, 5)
      .whenHeld(new intakeSpin(intake, true));

    new JoystickButton(js, 3)
      .whenHeld(new tilterSpin(tilter, false));
    new JoystickButton(js, 1)
      .whenHeld(new tilterSpin(tilter, true));

    /*
    new JoystickButton(js, 5)
      .whenHeld(new armSpin(arm, false));
    new JoystickButton(js, 7)
      .whenHeld(new armSpin(arm, true));
    */
    

  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */


  
  public Command getAutonomousCommand() {
    return new autonomous();
  }
}
