package com.example.jrtrail.service;

import com.example.jrtrail.model.application.Application;
import com.example.jrtrail.model.module.Modules;
import com.example.jrtrail.repository.ApplicationRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ApplicationServiceImplTest {

    @Mock
    private ApplicationRepository applicationRepository;
    @InjectMocks
    private ApplicationServiceImpl applicationService;

    private Application applicationToSave;

    @BeforeEach
    void setUp() {
        applicationToSave = new Application();
        applicationToSave.setTitle("Application");
        Modules module = new Modules("a", "a", false);
        Modules module1 = new Modules("a", "b", true);
        applicationToSave.getModules().add(module);
        applicationToSave.getModules().add(module1);
    }

    @Test
    void createApplication() {

        when(applicationRepository.save(any(Application.class))).thenReturn(applicationToSave);

        Application savedApplication = applicationService.addApplication(applicationToSave);

        assertNotNull(savedApplication);

        verify(applicationRepository, times(1)).save(any(Application.class));

    }

    @Test
    void isIdNotNull() {
        Application application = new Application();
        application.setApplicationID("application");
        application.setTitle("Application");

        applicationService.addApplication(application);
        assertNotNull(application.getApplicationID());
    }

    @Test
    void findApplicationById() {
        Application newapplication = new Application();
        newapplication.setApplicationID("test");
        newapplication.setTitle("test title");
        when(applicationRepository.findById(any())).thenReturn(Optional.of(newapplication));

        Application a = applicationService.findById(newapplication.getApplicationID());

        assertNotNull(a);
        assertEquals(newapplication.getApplicationID(), a.getApplicationID());

        verify(applicationRepository, times(1)).findById(any());
    }

    @Test
    void findAll() {
        Set<Application> applicationList = new HashSet<>();
        applicationList.add(applicationToSave);

        when(applicationRepository.findAll()).thenReturn(applicationList);

        Set<Application> applications = applicationService.findAll();

        assertNotNull(applications);
        assertEquals(1, applications.size());
    }

    @Test
    void deleteById() {
        applicationService.deleteById(applicationToSave.getApplicationID());
        verify(applicationRepository, times(1)).deleteById(any());
    }

    @Test
    void delete() {
        applicationService.delete(applicationToSave);

        verify(applicationRepository, times(1)).delete(applicationToSave);
    }
}