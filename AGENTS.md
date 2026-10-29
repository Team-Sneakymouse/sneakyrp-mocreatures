# AGENTS.md

## Repo-specific rules

- **Not a Paper plugin.** This is a Forge 1.12.2 mod (ForgeGradle 2.3, Java 8, source/target 1.8). Don't apply EmptyPlugin, Paper or Kotlin conventions.
- **Version lives in `build.properties`** (`mod_version`, `mod_name`). `build.gradle` composes the version from it; don't hardcode it elsewhere. (`build.gradle` still has a `replaceIn "ModConstants.java"` step, but that file no longer exists.)
- **Keep GPL attribution.** This is a fork of DrZhark's Mo' Creatures: preserve `LICENSE` and the credit in `README.md`; redistribution stays GPL-3.0.
- **Don't rename entity registry names or NBT keys** (`entity/`, `init/`) without a migration plan; existing worlds would lose their mobs.
