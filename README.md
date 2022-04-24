# CraftTweaker Addon MultiLoader Template

This is a template repository made using the [MultiLoader](https://github.com/jaredlll08/MultiLoader-Template) template. CraftTweaker is included as a `compileOnly` dependency, and its Forge and Fabric counterparts are under an `implementation` dependency.

The initial release targets 1.18.2, but you're free to modify your gradle.properties to update!

This means that most CraftTweaker classes can be placed inside of the Common module, and CrT will load them from there.

Implementations in the Forge and Fabric modules may or may not be required, depending on what you do with your mod and how much of it can be executed using the Common module and Vanilla Gradle.

In order to get Platform information in the Common module, use CraftTweaker's `Services.PLATFORM`, which is already there for you! Other MultiLoader mods might need to make their own service, but since this is a CraftTweaker addon, you can use its platform without a problem.

Good luck!

## Getting Started

This template follows the standard MultiLoader setup. This means the below guide applies to you too.

## IntelliJ IDEA
This guide will show how to import the MultiLoader Template into IntelliJ IDEA. The setup process is roughly equivalent to setting up Forge and Fabric independently and should be very familiar to anyone who has worked with their MDKs.

1. Clone or download this repository to your computer.
2. Configure the project by editing the `group`, `mod_name`, `mod_author`, and `mod_id` properties in the `gradle.properties` file. You will also need to change the `rootProject.name`  property in `settings.gradle`.
3. Refactor your packages if necessary.
4. Open the template's root folder as a new project in IDEA. This is the folder that contains this README file and the gradlew executable.
5. If your default JVM/JDK is not Java 16 you will encounter an error when opening the project. This error is fixed by going to `File > Settings > Build, Execution, Deployment > Build Tools > Gradle > Gradle JVM`and changing the value to a valid Java 16 JVM. You will also need to set the Project SDK to Java 16. This can be done by going to `File > Project Structure > Project SDK`. Once both have been set open the Gradle tab in IDEA and click the refresh button to reload the project.
6. Open the Gradle tab in IDEA if it has not already been opened. Navigate to `Your Project > Common > Tasks > vanilla gradle > decompile`. Run this task to decompile Minecraft.
7. Open the Gradle tab in IDEA if it has not already been opened. Navigate to `Your Project > Forge > Tasks > forgegradle runs > genIntellijRuns`. Run this task to set up run configurations for Forge.
8. Open your Run/Debug Configurations. Under the Application category there should now be options to run Forge and Fabric projects. Select one of the client options and try to run it.
9. Assuming you were able to run the game in step 7 your workspace should now be set up.

### Eclipse
While it is possible to use this template in Eclipse it is not recommended. During the development of this template multiple critical bugs and quirks related to Eclipse were found at nearly every level of the required build tools. While we continue to work with these tools to report and resolve issues support for projects like these are not there yet. For now Eclipse is considered unsupported by this project. The development cycle for build tools is notoriously slow so there are no ETAs available.

## Development Guide
When using this template the majority of your mod is developed in the Common project. The Common project is compiled against the vanilla game and is used to hold code that is shared between the different loader-specific versions of your mod. The Common project has no knowledge or access to ModLoader specific code, apis, or concepts. Code that requires something from a specific loader must be done through the project that is specific to that loader, such as the Forge or Fabric project.

Loader specific projects such as the Forge and Fabric project are used to load the Common project into the game. These projects also define code that is specific to that loader. Loader specific projects can access all of the code in the Common project. It is important to remember that the Common project can not access code from loader specific projects.


## Building
The output of your Forge and Fabric projects is copied over to `Common/output`.

This example mod also includes the CraftTweaker Annotation Processor so you can autogenerate documentation and PR to the CraftTweaker Documentation page.
Don't forge to add your JavaDocs!

##Custom Tasks

The following tasks have been added to make the process easier:
They are under the `build` group in your gradle tab.
 
- `buildProject` compiles both your Forge and Fabric mods.
- `generateDocs` generates the documentation using CraftTweaker's Annotation Processor and puts it in a folder called `docsOut` at your project's root directory.

