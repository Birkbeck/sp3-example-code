import dagger.Binds;
import dagger.Module;

/**
 * Dagger module for providing vehicles components.
 *
 * @author Donato Rimenti
 */
@Module
interface VehiclesModule {

    /**
     * Creates an {@link EngineImpl}.
     *
     * @return an {@link EngineImpl}
     */
//
    @Binds
    Engine bindEngine(EngineImpl e);

    /**
     * Creates a {@link BrandImpl}.
     *
     * @return a {@link BrandImpl}
     */
    @Binds
    Brand bindBrand(BrandImpl b);
}