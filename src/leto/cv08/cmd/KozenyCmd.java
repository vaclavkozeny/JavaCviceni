package src.leto.cv08.cmd;

import java.nio.file.Path;

public class KozenyCmd implements CmdInterface {
    private Path path;
    public KozenyCmd(String path) {
        this.path = Path.of(path);
    }

    @Override
    public String getPrompt() {
        return path.toAbsolutePath().normalize() + ">";
    }

    @Override
    public String getAktDir() {
        return path.toAbsolutePath().toString();
    }

    @Override
    public void cd(String adrPath) {
        Path p = Path.of(adrPath);
        if(!p.isAbsolute()){
            p = Path.of(path.toString(), p.toString());
        }
        if(p.toFile().isFile() || !p.toFile().exists())
            throw new AdresarNeexistujeException("Adresar " + p.toAbsolutePath() + " na disku neexistuje!");
        else{
            this.path = path.resolve(p).normalize();
        }
    }

    @Override
    public String dir() {
        StringBuilder sb = new StringBuilder();
        sb.append("Seznam souboru a adresaru v adresari ").append(path.toAbsolutePath().normalize()).append("\n");
        for (var p : path.toFile().listFiles()) {
            sb.append(p.getName()).append("\n");
        }
        return sb.toString();
    }

    @Override
    public String dir(String adrPath) {
        StringBuilder sb = new StringBuilder();
        Path p = Path.of(adrPath);
        sb.append("Seznam souboru a adresaru v adresari ").append(p.toAbsolutePath().normalize()).append("\n");
        for (var f : path.toFile().listFiles()) {
            sb.append(f.getName()).append("\n");
        }
        return sb.toString();
    }
}
