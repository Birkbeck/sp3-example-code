package template;

import template.Resource;

public class TemplateGof {

    public static void main(String[] args) {
        new ResourceUser().execute();
        new ResourceEmployer().execute();
    }

    public static abstract class AbstractResourceManipulatorTemplate {
        protected Resource resource;

        private void openResource() {
            resource = new Resource();
        }

        protected abstract void doSomethingWithResource();

        private void closeResource() {
            resource.dispose();
            resource = null;
        }

        public void execute() {
            openResource();
            try {
                doSomethingWithResource();
            } finally {
                closeResource();
            }
        }
    }

    public static class ResourceUser extends AbstractResourceManipulatorTemplate {
        @Override
        protected void doSomethingWithResource() {
            resource.useResource();
        }
    }

    public static class ResourceEmployer extends AbstractResourceManipulatorTemplate {
        @Override
        protected void doSomethingWithResource() {
            resource.employResource();
        }
    }
}
