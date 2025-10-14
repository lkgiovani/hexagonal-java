package hexagonal.demo.application.usecases;

public abstract class UnitUseCase<INPUT> {

    public abstract void execute(INPUT input);
}
