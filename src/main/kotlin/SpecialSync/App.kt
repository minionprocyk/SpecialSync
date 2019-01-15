package SpecialSync

import SpecialSync.modules.SyncModule
import com.authzee.kotlinguice4.getInstance
import com.google.inject.Guice
import main.kotlin.SpecialSync.SyncHandler
import java.nio.file.Paths

fun usage() {
    print("""
        Usage: sps <source> <outdir>

        e.g. specialsync /home/user/documents /mnt/media/documents
        Synchronizes two folders such that all files from the source directory are contained in the provided output
        directory. Folder structure is not maintained with this sync, however if a given folder does not exist in the
        <outdir> then one is created. If an already existing file exists in the <outdir> then that file will be replaced
        with the new original file from <source>.

        Options:
            -f force overwrite for already existing files in the <outdir>

    """.trimIndent())
}
fun main(args: Array<String>) {
    //validate inputs and spit usage
    //TODO: validate input with regex -- solving happy case for now
    if(args.size==2 &&(args[0].isNotBlank().and(args[1].isNotBlank()))) {
        val injector = Guice.createInjector(SyncModule())
        injector.getInstance<SyncHandler>().sync(Paths.get(args[0]), Paths.get(args[1]))
    }
    else {
        usage()
    }
}
