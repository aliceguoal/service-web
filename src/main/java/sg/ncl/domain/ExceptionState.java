package sg.ncl.domain;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Te Ye
 */
public enum ExceptionState {
    USER_NOT_FOUND_EXCEPTION("UserNotFoundException"),
    CREDENTIALS_UPDATE_EXCEPTION("CredentialsUpdateException"),
    NS_FILE_PARSE_EXCEPTION("NSFileParseException"),
    EXP_NAME_ALREADY_EXISTS_EXCEPTION("ExperimentNameAlreadyExistsException"),
    TEAM_NOT_FOUND_EXCEPTION("TeamNotFoundException"),
    APPLY_NEW_PROJECT_EXCEPTION("ApplyNewProjectException"),
    JOIN_PROJECT_EXCEPTION("JoinProjectException"),
    EXP_START_EXCEPTION("ExperimentStartException"),
    EXP_DELETE_EXCEPTION("ExperimentDeleteException"),
    TEAM_ID_NULL_OR_EMPTY_EXCEPTION("TeamIdNullOrEmptyException"),
    USER_ID_NULL_OR_EMPTY_EXCEPTION("UserIdNullOrEmptyException"),
    INVALID_TEAM_STATUS_EXCEPTION("InvalidTeamStatusException"),
    EXPERIMENT_NAME_ALREADY_EXISTS_EXCEPTION("ExperimentNameAlreadyExistsException"),
    USERNAME_ALREADY_EXISTS_EXCEPTION("UsernameAlreadyExistsException"),
    CREDENTIALS_NOT_FOUND_EXCEPTION("CredentialsNotFoundException"),
    EMAIL_NOT_VERIFIED_EXCEPTION("EmailNotVerifiedException"),
    USER_NOT_APPROVED_EXCEPTION("UserNotApprovedException"),
    INVALID_CREDENTIALS_EXCEPTION("InvalidCredentialsException"),
    EMAIL_ALREADY_EXISTS_EXCEPTION("EmailAlreadyExistsException"),
    FORBIDDEN_EXCEPTION("ForbiddenException"),
    PASSWORD_RESET_REQUEST_TIMEOUT_EXCEPTION("PasswordResetRequestTimeoutException"),
    PASSWORD_RESET_REQUEST_NOT_FOUND_EXCEPTION("PasswordResetRequestNotFoundException"),
    ADAPTER_DETERLAB_CONNECT_EXCEPTION("AdapterDeterLabConnectionFailedException"),
    TEAM_NAME_ALREADY_EXISTS_EXCEPTION("TeamNameAlreadyExistsException"),
    INVALID_TEAM_NAME_EXCEPTION("InvalidTeamNameException"),
    DATASET_NAME_IN_USE_EXCEPTION("DatasetNameInUseException");

    private static final Map<String, ExceptionState> map = new HashMap<>();

    static {
        for (ExceptionState e : ExceptionState.values()) {
            map.put(e.getExceptionName(), e);
        }
    }

    @Getter
    private String exceptionName;

    ExceptionState(String exceptionName) {
        this.exceptionName = exceptionName;
    }

    /**
     * Converts and returns exceptions thrown from services-in-one
     * Exception thrown from services-in-one is in this form [class.exceptionName]
     * e.g. sg.ncl.service.user.exceptions.UserNotFoundException to UserNotFoundException
     * @return the exceptionName only
     */
    public static ExceptionState parseExceptionState(String exceptionName) {
        return  map.get(exceptionName.substring(exceptionName.lastIndexOf('.') + 1));
    }

}