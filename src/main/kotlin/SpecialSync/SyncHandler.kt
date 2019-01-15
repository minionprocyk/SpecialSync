package main.kotlin.SpecialSync

import java.nio.file.FileVisitOption
import java.nio.file.Files
import java.nio.file.Path

class SyncHandler {
    fun sync(source: Path, destination: Path) {
        if (source.toFile().isDirectory.and(destination.toFile().isDirectory)) {
            println("SyncHandler::Running")
            //scan the source dir for new files to copy
            //make copy jobs to overwrite or copy files into destination
            Files.walkFileTree(source, )
        }
    }
}