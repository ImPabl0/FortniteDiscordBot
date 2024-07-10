package br.pablo.fortnite.services;

import br.pablo.fortnite.models.UserContext;
import br.pablo.fortnite.repositories.UserContextRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserContextService {

    @Autowired
    private UserContextRepository userContextRepository;

    public UserContext getContext(String userID) {
        Optional<UserContext> userContext = userContextRepository.findById(userID);
        if(userContext.isEmpty()) {
            UserContext newUserContext = new UserContext();
            newUserContext.setUserID(userID);
            newUserContext.setCurrentPage(0);
            userContextRepository.save(newUserContext);
            return newUserContext;
        }
        return userContext.get();
    }

    public void previousPage(String userID) {
        UserContext userContext = getContext(userID);
        userContext.setCurrentPage(userContext.getCurrentPage() - 1);
        userContextRepository.save(userContext);
    }

    public void nextPage(String userID) {
        UserContext userContext = getContext(userID);
        userContext.setCurrentPage(userContext.getCurrentPage() + 1);
        userContextRepository.save(userContext);
    }

    public void deleteContext(String userID) {
        userContextRepository.deleteById(userID);
    }

}
