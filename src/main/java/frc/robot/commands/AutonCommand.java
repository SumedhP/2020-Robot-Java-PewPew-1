package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.Hopper;
import frc.robot.subsystems.Indexer;
import frc.robot.subsystems.LimeLight;
import frc.robot.subsystems.Shooter;

public class AutonCommand extends SequentialCommandGroup {

    public AutonCommand(LimeLight lime, Shooter shooter, Hopper hopper, Indexer indexer) {
        super(new SequentialCommandGroup(new SpinUp(shooter).withTimeout(0.2), new FeedToShooter(-0.4, shooter, hopper, indexer)));
    }

}