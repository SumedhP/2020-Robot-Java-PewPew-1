/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import com.revrobotics.CANEncoder;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import frc.robot.commands.DriveCommand;

/**
 * The VM is configured to automatically run this class, and to call the functions corresponding to
 * each mode, as described in the TimedRobot documentation. If you change the name of this class or
 * the package after creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {

  public static RobotContainer m_robotContainer;

  //private CANSparkMax m_motor;
  
  /**
   * This function is run when the robot is first started up and should be used
   * for any initialization code.
   */

  @Override
  public void robotInit() {

    m_robotContainer = new RobotContainer();

    

    //m_motor = new CANSparkMax(deviceID, type); // Input the SparkMax port here *note* might need to add more if multiple sparkmax
    //m_motor.restoreFactoryDefaults(); // R estores the SparkMax code to Factory Default
    //m_motor.getEncoder(); //Vinay comment this out if this crashes the robot. I will work on fixing this when I have the ports/IDs. 

    // Instantiate our RobotContainer.  This will perform all our button bindings, and put our
    // autonomous chooser on the dashboard.
  }

  /**
   * This function is called every robot packet, no matter the mode. Use this for items like
   * diagnostics that you want ran during disabled, autonomous, teleoperated and test.
   *
   * <p>This runs after the mode specific periodic functions, but before
   * LiveWindow and SmartDashboard integrated updating.
   */
  @Override
  public void robotPeriodic() {
    CommandScheduler.getInstance().run();
    // Runs the Scheduler.  This is responsible for polling buttons, adding newly-scheduled
    // commands, running already-scheduled commands, removing finished or interrupted commands,
    // and running subsystem periodic() methods.  This must be called from the robot's periodic
    // block in order for anything in the Command-based framework to work.
  }

  /**
   * This function is called once each time the robot enters Disabled mode.
   */
  @Override
  public void disabledInit() {
  }

  @Override
  public void disabledPeriodic() {
  }

  /**
   * This autonomous runs the autonomous command selected by your {@link RobotContainer} class.
   */
  @Override
  public void autonomousInit() 
  {
    CommandScheduler.getInstance().cancelAll();
    //driveTrain.setDefaultCommand(new CenterTargetRobot());
    m_robotContainer.driveTrain.setDefaultCommand(m_robotContainer.getAutonomousCommand());
    
  }

  /*
   * This function is called periodically during autonomous.
   */
  @Override
  public void autonomousPeriodic() 
  {  
    
  }

  @Override
  public void teleopInit() {
    // This makes sure that the autonomous stops running when
    // teleop starts running. If you want the autonomous to
    // continue until interrupted by another command, remove
    // this line or comment it out.  
    CommandScheduler.getInstance().cancelAll();
    m_robotContainer = new RobotContainer();
    m_robotContainer.driveTrain.setDefaultCommand(new DriveCommand(
                                                                  ()->(-0.4*m_robotContainer.getLeft()), 
                                                                  ()->(-0.4*m_robotContainer.getRight()), 
                                                                  m_robotContainer.driveTrain));
    //driveTrain.setDefaultCommand(new ShootBall(()->(m_robotContainer.getLeft())));
    //driveTrain.setDefaultCommand(new ShootBall());
  }

  /**
   * This function is called periodically during operator control.
   */
  @Override
  public void teleopPeriodic() 
  {
    //System.out.println(driveTrain.getDefaultCommand());
   
  }

  @Override
  public void testInit() {
    // Cancels all running commands at the start of test mode.
    CommandScheduler.getInstance().cancelAll();
  }

  /**
   * This function is called periodically during test mode.
   */
  @Override
  public void testPeriodic() {
  }
}
