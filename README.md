# WIP!
A mod that emulates Bukkit server software without rewriting tons of MC base code

## TODO state
 - **AT** - 0?
 - **MD** - 23
 - **impl** - 362
 - **other** - 17
 - **NMS** - a lot
### Goals:
 - Add all Bukkit classes ✔
 - Add all CraftBukkit classes ✔
 - Resolve all mapping stuff and mark errors as TODO ✔
 - Create AT (Access Transformer) file for all fields/methods Bukkit changes to public/non-final ✔
 - Implement all (needed) methods and fields and remap them with some JarRemapper (including reflection!) **<- Current Goal**
 - Some ASM hook with which the ForgeKit would patch base MC classes to be compatible with Bukkit (the least possible amount)
 - Make this actually buildable
 - Get high because it's just not goddamn possible
 - Celebrate the New Year 2050
 - Add new goals

## MORE INFO
### Q&A

**Q:** Why are you doing this?

**A:** Because I felt bored of Fortnite and World of Tanks

**Q:** MKASFUIWQAFNHEGOUNAPMOVCOWUBOWA!

**A:** Yes

### TODO explanation:
 - `//TODO` If there is nothing after the `TODO`, I forgot to add something there
 - `//TODO AT` This means the line before contains a field/method which needs to have changed its access, this is the easiest one
 - `//TODO MD` Bukkit implements few methods in NMS classes that are easy to remap outside that class
 - `//TODO impl` The toughest one. Bukkit rewrites lots of base MC methods, fields and even type constructors, those must be either *somehow* remapped or worse, injected by ASM - which is the last option which should be avoided at all costs, thanks to CoreMods..
 - `//TODO ?` ?? ... Eclipse shows an error on this line and I don't know what causes it because it's just nonsense

All other "TODOs" are pretty much self-explaining. Remember, Bukkit also has its own "TODOs", but all of them have a space between slashes and T, just like this

`// TODO optimize`

### Setting up a (comfortable) workspace
1. Download/clone/fork the repo either from browser, GitHub Desktop app or by `./git`
2. If you are planning on doing a PRs, create new branch from master
3. Run `./gradlew setupDecompWorkspace` - this will create pure decompiled Forge-patched MC source code in `/build/tmp/recompileMc/sources` directory
4. Run `./gradlew eclipse` or another IDE based task to generate everything needed to import the project to that IDE (you can still import Gradle project though)
5. Import the `/sources` directory mentioned above as a source folder
6. You are ready to sacrifice your time

I should make a task that would simplify this process, but I am too lazy
## Credits
[Forge Dev Team](https://github.com/MinecraftForge/MinecraftForge) for creating MinecraftForge

[PaperMC Dev Team](https://github.com/PaperMC/Paper) for Paper API, even though ForgeKit includes only CraftBukkit *yet*

[Kettle Dev Team](https://github.com/KettleFoundation/Kettle) for simplifying the process of remapping

[GMaxtrixGames](https://github.com/GMatrixGames) for providing mappings