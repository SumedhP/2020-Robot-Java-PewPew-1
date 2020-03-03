/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveTrain;

public class DriveCommand extends CommandBase {
  /**
   * Creates a new DriveCommands.
   */

  private DriveTrain driveTrain;
  private DoubleSupplier leftVal; //DoubleSupplier is a supplier of double-valued results, allows us to get multiple values simultaneously
  private DoubleSupplier rightVal;

  public DriveCommand(DoubleSupplier leftVal, DoubleSupplier rightVal, DriveTrain driveTrain) {
    // Use addRequirements() here to declare subsystem dependencies.
    this.driveTrain = driveTrain;
    addRequirements(driveTrain);
    this.leftVal = leftVal;
    this.rightVal = rightVal;
  }

  /*public DriveCommand(double leftVal, double rightVal, DriveTrain driveTrain) {
    this.driveTrain = driveTrain;
    addRequirements(driveTrain);
    this.leftVal = leftVal;
    this.rightVal = rightVal;
  }*/

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    // System.out.println("L: " + leftVal.getAsDouble());
    // System.out.println("R: " + rightVal.getAsDouble() + "\n");
    driveTrain.tankDriveVolts(12.3*rightVal.getAsDouble(), 12.3*leftVal.getAsDouble());
    //driveTrain.driveCartesian(leftVal.getAsDouble(), rightVal.getAsDouble());
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
